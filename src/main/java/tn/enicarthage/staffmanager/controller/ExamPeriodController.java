package tn.enicarthage.staffmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.enicarthage.staffmanager.dto.ExamPeriodDTO;
import tn.enicarthage.staffmanager.model.ExamPeriod;
import tn.enicarthage.staffmanager.service.ExamPeriodService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/exam-periods")
@CrossOrigin(origins = "*")
public class ExamPeriodController {

    @Autowired
    private ExamPeriodService examPeriodService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ExamPeriodDTO> createExamPeriod(@RequestBody ExamPeriod examPeriod) {
        ExamPeriod created = examPeriodService.createExamPeriod(examPeriod);
        return ResponseEntity.ok(convertToDTO(created));
    }

    @GetMapping
    public ResponseEntity<List<ExamPeriodDTO>> getAllExamPeriods() {
        List<ExamPeriodDTO> periods = examPeriodService.getAllExamPeriods()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(periods);
    }

    @GetMapping("/active")
    public ResponseEntity<ExamPeriodDTO> getActiveExamPeriod() {
        return examPeriodService.getActiveExamPeriod()
                .map(period -> ResponseEntity.ok(convertToDTO(period)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/is-active")
    public ResponseEntity<Boolean> isExamPeriodActive() {
        return ResponseEntity.ok(examPeriodService.isExamPeriodActive());
    }

    @PutMapping("/{id}/activate")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ExamPeriodDTO> activateExamPeriod(@PathVariable Long id) {
        ExamPeriod activated = examPeriodService.activateExamPeriod(id);
        return ResponseEntity.ok(convertToDTO(activated));
    }

    @PutMapping("/{id}/deactivate")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deactivateExamPeriod(@PathVariable Long id) {
        examPeriodService.deactivateExamPeriod(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteExamPeriod(@PathVariable Long id) {
        examPeriodService.deleteExamPeriod(id);
        return ResponseEntity.ok().build();
    }

    private ExamPeriodDTO convertToDTO(ExamPeriod period) {
        return new ExamPeriodDTO(
                period.getId(),
                period.getStartDate(),
                period.getEndDate(),
                period.getActive(),
                period.getDescription(),
                period.getCreatedAt()
        );
    }
}
