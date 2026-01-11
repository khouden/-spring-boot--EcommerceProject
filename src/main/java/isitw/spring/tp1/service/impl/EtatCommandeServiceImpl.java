package isitw.spring.tp1.service.impl;

import isitw.spring.tp1.dao.EtatCommandeDao;
import isitw.spring.tp1.entity.Commande;
import isitw.spring.tp1.entity.EtatCommande;
import isitw.spring.tp1.service.constant.EtatCommandeConstant;
import isitw.spring.tp1.service.facade.EtatCommandeService;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtatCommandeServiceImpl implements EtatCommandeService {

    @Override
    public int save(EtatCommande etatCommande) {
        if (findByCode(etatCommande.getCode()) != null) {
            return -1;
        } else {
            dao.save(etatCommande);
            return 1;
        }
    }


    @Override
    public EtatCommande findByCode(String code) {
        return dao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String code) {
        return dao.deleteByCode(code);
    }

    @Override
    public EtatCommande findNew() {
            return findByCode(EtatCommandeConstant.New);
    }

    @Override
    public EtatCommande findOk() {
        return findByCode(EtatCommandeConstant.Ok);
    }

    @Override
    public EtatCommande findEncours() {
        return findByCode(EtatCommandeConstant.Pending);
    }

    @Override
    public List<EtatCommande> findAll() {
        return dao.findAll();
    }
//
//    @PostConstruct
//    public void createEtats(){
//        EtatCommande etat1 = new EtatCommande();
//        etat1.setCode("New");
//        save(etat1);
//        EtatCommande etat2 = new EtatCommande();
//        etat2.setCode("Pending");
//        save(etat2);
//        EtatCommande etat3 = new EtatCommande();
//        etat3.setCode("Ok");
//        save(etat3);
//    }

    public EtatCommandeServiceImpl(EtatCommandeDao dao) {
        this.dao = dao;
    }

    private EtatCommandeDao dao;
}
