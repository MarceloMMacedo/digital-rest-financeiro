package br.com.core.apifinanceiro.services;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

import br.com.apirestfinanceiro.services.exceptions.AuthorizationException;
import br.com.apirestfinanceiro.services.exceptions.DataIntegrityException;
import br.com.apirestfinanceiro.util.services.FilesService;
import br.com.core.apifinanceiro.config.services.UserService;
import br.com.core.apifinanceiro.dto.BaseDto;
import br.com.core.apifinanceiro.interfaces.ServicesInterfaces;
import br.com.core.apifinanceiro.security.UserSS;
import br.com.core.dbcore.domain.intefaces.BaseEntity;

public class ServiceImpl<T extends BaseEntity> implements ServicesInterfaces<T>, Serializable {

	private static final long serialVersionUID = 1L;

	 

	@Value("${jwt.secret}")
	private static String secret;

	@Value("${jwt.expiration}")
	private static Integer expiration;

	@Autowired
	FilesService filesService;

	T obj;

	public JpaRepository<T, Integer> repo() {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Class<T> getClasse() {
		Class<T> classe = null;
		try {
			Class<T> class1 = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
					.getActualTypeArguments()[0];

			classe = class1;
		} catch (Exception e) {
		}
		return classe;
	}

	@Override
	public T find(Integer id) {
		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Acesso negado");
		}
		try {
			obj = repo().findById(id).get();
		} catch (Exception e) {
			return null;
		}
		return obj;
	}

	@Override
	public T insert(T obj) {
		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Acesso negado");
		}
		obj.setEmpresa(user.getEmpresa());
		obj.setId(null);
		obj = repo().save(obj);
		return obj;
	}

	@Override
	public T update(T obj) {
		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Acesso negado");
		}

		obj.setEmpresa(user.getEmpresa());
		obj = repo().save(obj);
		return obj;
	}

	@Override
	public void delete(Integer id) {
		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Acesso negado");
		}
		find(id);
		try {
			repo().deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionados");
		}

	}

	@Override
	public List<T> findAll() {
		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Acesso negado");
		}
		List<T> find = repo().findAll();

		return find;
	}

	@Override
	public T findByEmail(String email) {
		
		return null;
	}

	@Override
	public Page<T> findPage(String name, Integer page, Integer linesPerPage, String orderBy, String direction) {
		
		return null;
	}

	
	
	@Override
	public String uploadProfilePicture(MultipartFile file, Integer id, String fieldname) {
		Field fldfonte = null;
		Object value = null;

		String filename = "";
		obj = repo().findById(id).get();
		try {

			fldfonte = getClasse().getDeclaredField(fieldname);

			fldfonte.setAccessible(true);
			value = fldfonte.get(obj);

		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e1) {
			
			e1.printStackTrace();
		}
		fldfonte.setAccessible(true);

		try {
			filename = filesService._uploadProfilePicture(file, (String) value);

		} catch (Exception e) {
			filename = filesService._uploadProfilePicture(file, "");
		}
		// System.out.println(filesService.downloadFile(filename));

		try {
			fldfonte.set(obj, filename);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			
			e.printStackTrace();
		}
		update(obj);

		try {
			return filesService.downloadFile(filename);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return fieldname;
	}

	@Override
	public List<T> findAllName(String name) {
		
		return null;
	}

	@Override
	public List<T> SetImg(String FieldImage, String FieldView, List<T> list) {
		Field fldfonte = null;
		Field fldview = null;
		Object value = null;
		try {

			fldfonte = getClasse().getDeclaredField(FieldImage);
			fldview = getClasse().getDeclaredField(FieldView);

			for (T obj : list) {
				fldfonte.setAccessible(true);
				fldview.setAccessible(true);
				value = fldfonte.get(obj);
				String s = (String) value;
				if (s == null || s == "null" || s == "" || s.equals(null) || s.equals("null") || s.equals("")) {
				//	fldview.set(obj, "");
				} else
					try {
						fldview.set(obj, filesService.downloadFile(s));
					} catch (IOException e) {
						
						e.printStackTrace();
					}
			}

		} catch (Exception e) {
			
		}
		return list;
	}

	@Override
	public T SetImgSingle(String FieldImage, String FieldView, T obj) {
		Field fldfonte = null;
		Field fldview = null;
		Object value = null;
		try {

			fldfonte = getClasse().getDeclaredField(FieldImage);
			fldview = getClasse().getDeclaredField(FieldView);
			fldfonte.setAccessible(true);
			fldview.setAccessible(true);
			value = fldfonte.get(obj);
			String s = (String) value;
			if (s == null || s == "null" || s == "" || s.equals(null) || s.equals("null") || s.equals("")) {
				//fldview.set(obj, "");
			} else {
				fldview.set(obj, filesService.downloadFile(s));
			}
		} catch (Exception e) {
			
		}

		return obj;
	}

	@Override
	public List<BaseDto > findBaseAll() {
		return null;
		/*UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Acesso negado");
		}
		List<T> find = repo().findAll();
		List<BaseDto > baseDto = new ArrayList<>();
		for (T t : find) {
			baseDto.add(new BaseDto<T>(t));
		}
		return baseDto;*/
	}

	@Override
	public List<BaseDto> SetListBaseImg(String FieldImage, String FieldView, List<T> list) {
		return null;
	/*	Field fldfonte = null;
		Field fldview = null;
		Object value = null;
		List<BaseDto<T>> baseDto = new ArrayList<>();
		try {

			fldfonte = getClasse().getDeclaredField(FieldImage);
			fldview = getClasse().getDeclaredField(FieldView);

			for (T obj : list) {
				fldfonte.setAccessible(true);
				fldview.setAccessible(true);
				value = fldfonte.get(obj);
				String s = (String) value;
				if (s == null || s == "null" || s == "" || s.equals(null) || s.equals("null") || s.equals("")) {
					//fldview.set(obj, "");
				} else
					try {
						fldview.set(obj, filesService.downloadFile(s));
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				baseDto.add(new BaseDto<T>(obj));
			}

		} catch (Exception e) {
			
		}

		return baseDto;*/
	}

}
