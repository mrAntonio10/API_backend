package com.upb.upb;


import com.upb.upb.db.model.Usuario;
import com.upb.upb.db.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Slf4j
@SpringBootApplication
public class UpbGestionApplication implements CommandLineRunner {
	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(UpbGestionApplication.class, args);
		log.info("API 2023 - UPB SANTA CRUZ");
	}

	@Override
	public void run(String... arg) throws Exception{
		addUser();
	}

	private void addUser(){
		if(usuarioRepository.findAll().isEmpty()) {
			Usuario usuario = new Usuario();
			usuario.setNombreUsuario("admin");
			usuario.setPassword("password");
			usuario.setNombreCompleto("Administrador de Sistema");
			usuario.setRol(1L);
			usuario.setEstado(false);
			usuarioRepository.save(usuario);

		}
	}
}
