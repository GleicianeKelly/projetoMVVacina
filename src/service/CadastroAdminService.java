package service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import dao.CadastroAdminDao;
import model.CadastroAdmin;
import model.exception.DbException;
import repository.CadastroAdminRepository;

public class CadastroAdminService {

	private CadastroAdminRepository cadastro;

	public CadastroAdminService() throws ClassNotFoundException, SQLException {
		super();
		this.cadastro = new CadastroAdminDao();
	}

	public CadastroAdmin encontrarPorNome(String nome) {
		try {
			Optional<CadastroAdmin> cadastroEncontrado = this.cadastro.findByName(nome);
			if (!cadastroEncontrado.isPresent()) {
				throw new DbException("Usuário não encontrado");
			}
			return cadastroEncontrado.get();
		} catch (NullPointerException e) {
			return null;
		}

	}

	public void salvar(CadastroAdmin object) {
		try {
			Optional<CadastroAdmin> cadastroEncontrado = Optional.ofNullable(encontrarPorNome(object.getNome()));
			if (!cadastroEncontrado.isPresent()) {
				this.cadastro.save(object);

			}

		} catch (RuntimeException e) {
			System.out.println("Não pode ser cadastrado" + e);

		}

	}

	public boolean deletar(Integer id) {
		boolean ok = this.cadastro.delete(id);
		if (ok == false) {
			System.out.println("Paciente não pode ser deletado");
		}
		return ok;
	}

	public void editar(CadastroAdmin object) {
		this.cadastro.update(object);
	}

	public CadastroAdmin findById(Integer id) throws ClassNotFoundException {
		Optional<CadastroAdmin> cadastroEncontrado = this.cadastro.findById(id);
		if (!cadastroEncontrado.isPresent()) {
			throw new DbException("Paciente não encontrado");
		}
		return cadastroEncontrado.get();

	}

	public List<CadastroAdmin> findAll() throws ClassNotFoundException {
		List<CadastroAdmin> lista = this.cadastro.findAll();
		if (lista.isEmpty()) {
			throw new DbException("Lista vazia!");
		}
		return lista;

	}

	public static void main(String args[]) throws ClassNotFoundException, SQLException {

		CadastroAdminService cadastroService = new CadastroAdminService();
		CadastroAdmin admin = new CadastroAdmin();

		admin.setNome("Goku");
		admin.setSenha("1234");
		cadastroService.salvar(admin);

	}

}
