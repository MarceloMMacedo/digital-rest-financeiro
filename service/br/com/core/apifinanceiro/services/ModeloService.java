package br.com.core.apifinanceiro.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.core.apifinanceiro.ModeloRepository;
import br.com.core.apifinanceiro.dto.BaseDto;
import br.com.core.dbcore.domain.estoque.Modelo;

@Service
public class ModeloService extends ServiceImpl<Modelo> {
	 
	private static final long serialVersionUID = 1L;
	@Autowired
	ModeloRepository service;
	
	 @Override
	public JpaRepository<Modelo, Integer> repo() { 
		return service;
	}
		@Override
		public List<Modelo> findAll() {
			 
			return super.SetImg("avatar", "avatarView", super.findAll());
			 
		}

		@Override
		public List<BaseDto> findBaseAll() {
			List<BaseDto> baseDto = new ArrayList<>();
			for (Modelo p : findAll()) {

				baseDto.add(new BaseDto(p.getId(), p.getName(), null, p.getAvatar(), p.getAvatarView(), null));
			}
			return baseDto;
		}
}
