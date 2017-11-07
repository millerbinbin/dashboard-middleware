package com.jd.logistics.cloud.data.implement;

import com.jd.logistics.cloud.data.domain.Function;
import com.jd.logistics.cloud.data.repository.FuncRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author hubin
 * @Description:
 * @Date 2017/10/31 10:17
 */
@Service
public class FuncServiceImpl implements FuncService {
    @Autowired
    FuncRepository funcRepository;

    @Override
    public List<Function> getFuncByType(int type) {
        return funcRepository.getByType(type);
    }

    @Override
    public List<Function> getAllFunc() {
        return funcRepository.getAll();
    }

    @Override
    public void updateFuncType(Function func) {
        funcRepository.update(func);
    }
}
