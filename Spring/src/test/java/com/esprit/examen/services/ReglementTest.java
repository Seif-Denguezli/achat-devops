package com.esprit.examen.services;

import com.esprit.examen.entities.Reglement;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
 class ReglementTest {

    @Autowired
    IReglementService reglementService;

    @Test
    void addReglementTest() {
        Reglement reglement = new Reglement();
        List<Reglement> reglementList = new ArrayList<>();
        for (Long i=1L;i<=5L;i++) {
            reglement.setIdReglement(i);
            reglement.setDateReglement(new Date());
            reglement.setFacture(null);
            reglement.setMontantPaye(5000);
            reglement.setMontantRestant(1200);
            reglement.setPayee(false);
            Reglement reg = reglementService.addReglement(reglement);
            reglementList.add(reg);
        }
        assertEquals(5,reglementList.size());
    }

    @Test
    void retrieveAllReglementsTest() {
        List<Reglement> reglements = reglementService.retrieveAllReglements();
        assertEquals(5, reglements.size());
    }

    @Test
    void retrieveReglementTest() {
        Reglement reg1 = reglementService.retrieveReglement(2L);
        Reglement reg2 = reglementService.retrieveReglement(4L);
        assertNotNull(reg1);
        assertNotNull(reg2);
    }

    @Test
    void getChiffreAffaireEntreDeuxDateTest() {
        Date date1 = new Date(2022, 11, 9);
        Date date2 = new Date(2022, 11, 10);
        float ca = 0;
        ca = reglementService.getChiffreAffaireEntreDeuxDate(date1, date2);
        assertTrue(ca > 0);
    }






}
