package com.jd.logistics.cloud.data.web.api;

import com.jd.logistics.cloud.data.domain.Function;
import com.jd.logistics.cloud.data.service.FuncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/31 10:16
 */
@RestController
public class FuncRestController implements FuncApi{
    @Autowired
    FuncService funcService;
    @Override
    public List<Function> getFuncByType(@PathVariable("type") int type) {
        return funcService.getFuncByType(type);
    }

    @Override
    public List<Function> getFunc() {
        return funcService.getAllFunc();
    }

    @Override
    public ResponseEntity updateFuncType(@Valid @RequestBody List<Function> functionList) {
        for(Function function : functionList) {
            funcService.updateFuncType(function);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
