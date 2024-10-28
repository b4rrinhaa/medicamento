package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Medicamentos;
import com.example.demo.services.MedicamentoServices;


@RestController
@RequestMapping("/Medicamento")
public class MedicamentoController {

	private MedicamentoServices medicamentoService;

	@Autowired
	public MedicamentoController(MedicamentoServices medicamentoService) {
		this.medicamentoService = medicamentoService;
	}

	@PostMapping("/criar")
	public Medicamentos criarUsuario(@RequestBody Medicamentos medicamento) {
		return medicamentoService.salvarMedicamento(medicamento);
	}

	@GetMapping
	public List<Medicamentos> buscarTodos() {
		return medicamentoService.buscarTodosMedicamentos();
	}

	@GetMapping("/{id}")
	public Medicamentos buscarPorId(@PathVariable Long id) {
		return medicamentoService.buscarMedicamentoPorId(id);
	}

	@DeleteMapping("/{id}")
	public void deletarMedicamento(@PathVariable Long id) {
		medicamentoService.excluirMedicamento(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Medicamentos> atualizarMedicamento(@PathVariable Long id, @RequestBody Medicamentos medicamento) {
		Medicamentos medicamentoAtualizado = medicamentoService.atualizarMedicamento(id, medicamento);
		if (medicamentoAtualizado != null) {
			return ResponseEntity.ok(medicamentoAtualizado);
		} else {
			return null;
		}
	}

}