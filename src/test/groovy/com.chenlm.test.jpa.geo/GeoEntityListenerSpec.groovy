package com.chenlm.test.jpa.geo

import be.janbols.spock.extension.dbunit.DbUnit
import com.chenlm.test.jpa.geo.TestEntity
import com.chenlm.test.jpa.geo.TestRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.ApplicationContext
import spock.lang.Specification

import javax.persistence.EntityManager
import javax.sql.DataSource

@DataJpaTest
class GeoEntityListenerSpec extends Specification {


    @Autowired
    TestRepository testRepository

    @Autowired
    EntityManager entityManager

    @Autowired
    DataSource dataSource

    @Autowired
    ApplicationContext applicationContext

    def "testAdd"() {
        given:
        testRepository.save(new TestEntity(name: "hello", lat: 30.549608, lon: 114.376971))
        def testEntity = testRepository.getOne(1L)
        expect:
        "wt3mf9qu2e" == testEntity.geoCode
    }

    @DbUnit(
            content = {
                test_entity(id: 1, name: "hello", lat: 30.549608, lon: 114.376971, geo_code: "wt3mf9qu2e")
            })
    def "testUpdate"() {
        given:
        def testEntity = testRepository.getOne(1L)
        testEntity.lat = 28.549608
        testEntity = testRepository.save(testEntity)
        testRepository.findAll()
        expect:
        "wt166tqc88" == testEntity.geoCode
    }

}
