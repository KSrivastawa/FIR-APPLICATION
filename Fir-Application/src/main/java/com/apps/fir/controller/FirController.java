package com.apps.fir.controller;

import com.apps.fir.entity.FirModel;
import com.apps.fir.exception.FirException;
import com.apps.fir.serviceimpl.FirModelServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/masaifir/user")
public class FirController {

    @Autowired
    private FirModelServiceImpl firModelService;

    @PostMapping("/fir")
    public ResponseEntity<FirModel> registerFir(@Valid @RequestBody FirModel firModel, @RequestParam String key) throws FirException {

        return ResponseEntity.ok(firModelService.registerFir(key, firModel));
    }

}
