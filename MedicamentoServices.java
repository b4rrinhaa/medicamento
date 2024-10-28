package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Medicamentos;
import com.example.demo.repositories.MedicamentosRepository;

@Service
public class MedicamentoServices {
	private final MedicamentosRepository medicamentosRepository;

	@Autowired
	public MedicamentoServices(MedicamentosRepository medicamentosRepository) {
		this.medicamentosRepository = medicamentosRepository;
	}

	public Medicamentos salvarMedicamento(Medicamentos medicamentos) {
		return medicamentosRepository.save(medicamentos);
	}

	public Medicamentos buscarMedicamentoPorId(Long id) {
		return medicamentosRepository.findById(id).orElse(null);
	}

	public List<Medicamentos> buscarTodosMedicamentos() {
		return medicamentosRepository.findAll();
	}

	public void excluirMedicamento(Long id) {
		medicamentosRepository.deleteById(id);
	}

	public Medicamentos atualizarMedicamento(Long id, Medicamentos medicamentoAtualizado) {
		Optional<Medicamentos> medicamentoExistente = medicamentosRepository.findById(id);
		if (medicamentoExistente.isPresent()) {
			Medicamentos medicamento = medicamentoExistente.get();
			medicamento.setNome(medicamentoAtualizado.getNome());
			medicamento.setIdFornecedor(medicamentoAtualizado.getIdFornecedor());
			medicamento.setBula(medicamentoAtualizado.getBula());
			medicamento.setDataValidade(medicamentoAtualizado.getDataValidade());
			return medicamentosRepository.save(medicamento);
		} else {
			return null;
		}
	}
}