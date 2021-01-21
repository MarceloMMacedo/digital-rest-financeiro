package br.com.apifinanceiro.services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.apidigitalfinanceiro.enums.StatusActiv;
import br.com.apifinanceiro.config.services.UserService;
import br.com.apifinanceiro.domain.estoque.Modelo;
import br.com.apifinanceiro.domain.estoque.Patrimonio;
import br.com.apifinanceiro.dto.BaseDto;
import br.com.apifinanceiro.security.UserSS;
import br.com.apirestfinanceiro.repository.ModeloRepository;
import br.com.apirestfinanceiro.repository.PatrimonioRepository;
import br.com.apirestfinanceiro.services.exceptions.AuthorizationException;

@Service
public class PatrionioService extends ServiceImpl<Patrimonio> {

	private static final long serialVersionUID = 1L;

	@Autowired
	PatrimonioRepository repo;
	
	 
	@Override
	public JpaRepository<Patrimonio, Integer> repo() {
		return  repo ;
	}

	@Autowired
	ModeloRepository modeloRepository;

	@Override
	public List<Patrimonio> findAll() {
		List<Patrimonio> l=new LinkedList<>();
		 l =  repo.findAllByStatus(StatusActiv.ATIVO.getDescricao());
		l=super.SetImg("avatar", "avatarView", l);
		l=super.SetImg("imagepatrimonio", "imagepatrimonioView", l);
		return l;
	}

	@Override
	public List<BaseDto> findBaseAll() {
		List<BaseDto> baseDto = new ArrayList<>();
		for (Patrimonio p : findAll()) {

			baseDto.add(new BaseDto(p.getId(), p.getName(), p.getCodPatrimonio(), p.getAvatar(), p.getAvatarView(), null));
		}
		return baseDto;
	}

	public String imagAvatar(MultipartFile file, Integer id) {
		return super.uploadProfilePicture(file, id, "avatar");
	}

	public String imagRemocao(MultipartFile file, Integer id) {
		return super.uploadProfilePicture(file, id, "imagepatrimonio");
	}

	@Override
	public String uploadProfilePicture(MultipartFile file, Integer id, String fieldname) {
		return super.uploadProfilePicture(file, id, fieldname);
	}

 	@Override
	public Patrimonio update(Patrimonio obj) {
 		if (obj.getModelo().getId() == null) {
			 List<Modelo> mm =modeloRepository.findAll();
			 Modelo m;
			 if (mm.size() == 0) {
				 m=new Modelo("New Model", null);
				  m= modeloRepository.save(m);
			 } else m = mm.get(0);
			 obj.setModelo(m);
 		}
			 
		return super.update(obj);
	}
 
	@Override
	public Patrimonio insert(Patrimonio obj) {
		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Acesso negado");
		}
		obj.setEmpresa(user.getEmpresa());
		 obj.setStatus(StatusActiv.ATIVO.getDescricao());
		if (obj.getModelo().getId() == null) {
			 List<Modelo> mm =modeloRepository.findAll();
			 Modelo m;
			 if (mm.size() == 0) {
				 m=new Modelo("New Model", null);
				m= modeloRepository.save(m);
			 } else m = mm.get(0);
			 obj.setModelo(m);
			 
		 }
		return super.insert(obj);
	}
	 
	@Override
	public Patrimonio find(Integer id) {
		Patrimonio p=SetImgSingle("avatar", "avatarView", super.find(id));
		p=SetImgSingle("imagepatrimonio", "imagepatrimonioView", p);
		return   p;
	}
}
