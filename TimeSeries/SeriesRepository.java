package Zade.Server.TimeSeries;

import org.springframework.data.jpa.repository.JpaRepository;

/*
Injected by constructor into the controll
 */
public interface SeriesRepository extends JpaRepository<Series, Long> {
}