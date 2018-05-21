package by.nc.school.dev.example.spring.data.persistence;

import by.nc.school.dev.example.spring.data.model.ReportCard;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by PC on 16-May-18.
 */
public interface ReportCardRepository extends JpaRepository<ReportCard, Long> {
    ReportCard getReportCardByStudentId(Long studentId);
}
