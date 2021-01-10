package br.com.apirestfinanceiro.util.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.SignUrlOption;

import br.com.core.apifinanceiro.config.services.UserService;
import br.com.core.apifinanceiro.security.UserSS;
import br.com.core.apifinanceiro.services.EmpresaService;
import br.com.core.dbcore.domain.pessoas.Empresas;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class UtilFile implements FilesService, Serializable {
	@Value("${bucketBaseCompany}")
	private String bucket;

	@Autowired
	ResourceLoader resourceLoader;

	@Value("${spring.couchbase.bucket.name}")
	private String bucketdounload;

	@Value("${spring.cloud.gcp.config_projectId}")
	private String projectId;

	@Value("${spring.cloud.gcp.credentials.location}")
	private String credencial;

	@Autowired
	private Storage storage;

	@Autowired
	EmpresaService empresaService;

	@Override
	public byte[] ViewPdf(Map<String, Object> parameters, List<?> source, String templates)
			throws JRException, IOException {
		return null;

		// return createPdfReport(parameters, source, templates);
	}

	public byte[] createPdfReport(Map<String, Object> parameters, List<?> source, String templates)
			throws JRException, IOException {
		UserSS user = UserService.authenticated();

		Empresas company = empresaService.find(user.getEmpresa().getId());
		String img = company.getAvatarView();
		String v = bucket + "/";
		String s =company.getAvatarView();// bucket + "/" + company.getAvatar();// s = profileImage company.setAvatar(bucket + "/" +
														// company.getAvatar());
		s = s.substring(v.length());

		 
		String urlCabecalho = null;
		Resource res = resourceLoader.getResource("classpath:/templates/report/heard/");
		try {
			urlCabecalho = res.getURI().getPath();
			System.out.println(res.getURI());
		} catch (IOException e) {

			e.printStackTrace();
		}
		List<Empresas> listCompany = new LinkedList<>();
		listCompany.add(company);
		parameters.put("company", listCompany);

		parameters.put("heard", urlCabecalho + "/Cabecalho.jasper");

		byte[] bytes = null;

		// Fetching the .jrxml file from the resources folder. final
		InputStream stream = this.getClass().getResourceAsStream(templates);

		// Compile the Jasper report from .jrxml to .japser final
		JasperReport report = JasperCompileManager.compileReport(stream);

		// Fetching the employees from the data source. final
		JRBeanCollectionDataSource source$ = new JRBeanCollectionDataSource(source);

		// Adding the additional parameters to the pdf.

		parameters.put("createdBy", "javacodegeek.com");

		// Filling the report with the employee data and additional parameters //
		// information. final
		JasperPrint print = JasperFillManager.fillReport(report, parameters, source$);

		final String filePath = "\\"; // Export the report to a PDF file.

		return bytes = JasperExportManager.exportReportToPdf(print);
	}

	@Override
	public String downloadFile(String fileName) throws IOException {

		Resource res = resourceLoader.getResource("classpath:/templates/tmp");
		File ins = ResourceUtils.getFile(credencial);
		// InputStream in = new FileInputStream(ins);

		// ="cliente5ef7668b24f13062db255a24.png";

		URL signedUrl = null;
		try {
			signedUrl = storage.signUrl(BlobInfo.newBuilder(bucketdounload, fileName).build(), 1, TimeUnit.DAYS,
					SignUrlOption.signWith(ServiceAccountCredentials.fromStream(new FileInputStream(ins))));
		} catch (UnknownHostException e) {
			return "";
		} catch (IOException e) {
			e.printStackTrace();
		}
		return signedUrl.toString();
	}

	@Override
	public URI uploadProfilePicture(MultipartFile multipartFile) {
		String bucketName = bucketdounload;
		try {

			storage.delete(bucketName, multipartFile.getOriginalFilename());

		} catch (Exception e) {
			// TODO: handle exception
		}
		try {

			File ins = ResourceUtils.getFile(credencial);
			InputStream in = new FileInputStream(ins);

			BlobInfo blobInfo = storage.create(
					BlobInfo.newBuilder(bucketName, multipartFile.getOriginalFilename())
							.setContentType(multipartFile.getContentType()).build(), // get original file name
					multipartFile.getBytes()// the file

			);
		} catch (IllegalStateException | IOException e) {
			System.out.println(e.getMessage());
		}

		return null;
	}

	@Override
	public void deleteimage(String filename) {
		String bucketName = bucket;
		try {

			storage.delete(bucketName, filename);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public byte[] viewListPatrimonio() throws JRException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public static String getAlphaNumericString(int n) {

		// chose a Character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}

	@Override
	public String _uploadProfilePicturefile(String fileName, String filename2) {

		Resource res = resourceLoader.getResource("classpath:static/assets/" + fileName);
//application/pdf
		File convFile;
		try {
			convFile = res.getFile();// new File(res.getURI());

			FileOutputStream fos = new FileOutputStream(convFile);

			FileInputStream input = new FileInputStream(convFile);
			Path path = Paths.get(convFile.getPath());
			String name = fileName;
			String originalFileName = fileName;
			String contentType = "application/pdf";
			byte[] content = null;
			try {
				content = Files.readAllBytes(path);
			} catch (final IOException e) {
			}
			MultipartFile result = new MockMultipartFile(name, originalFileName, contentType,
					org.apache.commons.io.IOUtils.toByteArray(input));

			String extension = FilenameUtils.getExtension(convFile.getName());
			if (filename2 == "" || filename2.equals("")) {
				filename2 = getAlphaNumericString(10) + "." + extension;
			}
			try {
				String bucketName = bucketdounload;
				String f = filename2;
				File ins = ResourceUtils.getFile(credencial);
				InputStream in = new FileInputStream(ins);

				BlobInfo blobInfo = storage.create(
						BlobInfo.newBuilder(bucketName, filename2).setContentType(result.getContentType()).build(),
						result.getBytes()// the file

				);
			} catch (IllegalStateException | IOException e) {
				System.out.println(e.getMessage());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filename2;
	}

	@Override
	public String _uploadProfilePicture(MultipartFile multipartFile, String filename) {
		String bucketName = bucketdounload;
		String fileName = "";
		String f = "";
		String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
		if (filename == "" || filename.equals("")) {
			fileName = getAlphaNumericString(10) + "." + extension;
		} else {
			fileName = filename;

		}

		try {
			f = fileName;
			File ins = ResourceUtils.getFile(credencial);
			InputStream in = new FileInputStream(ins);

			BlobInfo blobInfo = storage.create(
					BlobInfo.newBuilder(bucketName, fileName).setContentType(multipartFile.getContentType()).build(),
					multipartFile.getBytes()// the file

			);
		} catch (IllegalStateException | IOException e) {
			System.out.println(e.getMessage());
		}

		return f;
	}

}
