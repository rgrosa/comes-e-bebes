package br.com.project.application.controller;


import br.com.project.application.resource.Response;
import br.com.project.domain.dto.AcquisitionDTO;
import br.com.project.domain.dto.ItemDTO;
import br.com.project.domain.service.AcquisitionService;
import br.com.project.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AcquisitionController {

    @Autowired
    AcquisitionService acquisitionService;


    @PostMapping("/acquisition")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response> postItem(
            @RequestBody final AcquisitionDTO acquisition) throws Exception {
        return ResponseEntity.ok().
                body(new Response(200,
                        "Success",
                        acquisitionService.postAcquisition(acquisition))
                );
    }

    @GetMapping("/acquisition/history")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response> getHistoryList(Long userId) throws Exception {
        return ResponseEntity.ok().
                body(new Response(200,
                        "Success",
                        acquisitionService.getAcquisitionHistory(userId))
                );
    }

}
