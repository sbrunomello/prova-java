package br.com.confidencecambio.javabasico;

import br.com.confidencecambio.javabasico.service.HelloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRs {

    private HelloService service;

    public HelloWorldRs(final HelloService service) {

        this.service = service;
    }

    @RequestMapping(value = "/ola-mundo", method = RequestMethod.GET)
    public ResponseEntity<String> olaMundo(@RequestParam(value = "nome", required = false) String nome) {
        var retorno = "Ola " + service.retornaValorValido(nome);
        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }
}
