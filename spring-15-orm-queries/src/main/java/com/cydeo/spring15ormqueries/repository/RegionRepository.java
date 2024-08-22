package com.cydeo.spring15ormqueries.repository;

import com.cydeo.spring15ormqueries.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

    // display all regions in Canada
    List<Region> findByCountry(String country);

    // display all regions in Canada without duplicates
    List<Region> findDistinctByCountry(String state);

    // display all regions with country name includes "United"
    List<Region> findByCountryContaining(String containExpression);

    // display all regions with country name includes "United" in order
    List<Region> findByCountryContainingOrderByCountry(String containExpression);

    // display top 2 regions in Canada
    List<Region> findTop2ByCountry(String country);

}
