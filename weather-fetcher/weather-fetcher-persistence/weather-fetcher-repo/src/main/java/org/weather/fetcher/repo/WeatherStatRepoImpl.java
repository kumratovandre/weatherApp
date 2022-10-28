package org.weather.fetcher.repo;

import lombok.Getter;
import lombok.Setter;
import org.weather.fetcher.repo.model.WeatherStat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class WeatherStatRepoImpl implements WeatherStatRepo {

    @Getter
    @PersistenceContext(unitName = "weatherPU")
    private EntityManager em;

    @Override
    public void save(WeatherStat ws) {
        em.persist(ws);
    }
}
