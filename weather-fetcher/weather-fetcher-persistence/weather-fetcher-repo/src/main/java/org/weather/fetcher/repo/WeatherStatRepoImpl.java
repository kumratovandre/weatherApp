package org.weather.fetcher.repo;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.weather.fetcher.repo.model.WeatherStat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@NoArgsConstructor
@Transactional
public class WeatherStatRepoImpl implements WeatherStatRepo {

    @Setter
    @PersistenceContext(unitName = "weatherPU")
    private EntityManager em;

    @Override
    public void save(WeatherStat ws) {
        em.persist(ws);
    }
}
