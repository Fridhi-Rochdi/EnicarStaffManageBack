package tn.enicarthage.staffmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.enicarthage.staffmanager.model.ExamPeriod;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ExamPeriodRepository extends JpaRepository<ExamPeriod, Long> {
    Optional<ExamPeriod> findByActiveTrue();
    List<ExamPeriod> findByStartDateLessThanEqualAndEndDateGreaterThanEqual(LocalDateTime start, LocalDateTime end);
}
