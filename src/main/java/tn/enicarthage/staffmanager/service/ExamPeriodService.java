package tn.enicarthage.staffmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.enicarthage.staffmanager.model.ExamPeriod;
import tn.enicarthage.staffmanager.repository.ExamPeriodRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ExamPeriodService {

    @Autowired
    private ExamPeriodRepository examPeriodRepository;

    @Transactional
    public ExamPeriod createExamPeriod(ExamPeriod examPeriod) {
        return examPeriodRepository.save(examPeriod);
    }

    @Transactional
    public ExamPeriod activateExamPeriod(Long id) {
        // Désactiver toutes les périodes actives
        examPeriodRepository.findByActiveTrue().ifPresent(period -> {
            period.setActive(false);
            examPeriodRepository.save(period);
        });

        // Activer la période demandée
        ExamPeriod period = examPeriodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exam period not found"));
        period.setActive(true);
        return examPeriodRepository.save(period);
    }

    @Transactional
    public void deactivateExamPeriod(Long id) {
        ExamPeriod period = examPeriodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exam period not found"));
        period.setActive(false);
        examPeriodRepository.save(period);
    }

    public Optional<ExamPeriod> getActiveExamPeriod() {
        return examPeriodRepository.findByActiveTrue();
    }

    public boolean isExamPeriodActive() {
        return examPeriodRepository.findByActiveTrue().isPresent();
    }

    public List<ExamPeriod> getAllExamPeriods() {
        return examPeriodRepository.findAll();
    }

    public ExamPeriod getExamPeriodById(Long id) {
        return examPeriodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exam period not found"));
    }

    @Transactional
    public void deleteExamPeriod(Long id) {
        examPeriodRepository.deleteById(id);
    }
}
