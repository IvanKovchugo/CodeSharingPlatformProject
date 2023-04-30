package com.ivankauchuha.codesharingplatformproject.businesslayer;

import com.ivankauchuha.codesharingplatformproject.datalayer.CodeRepository;
import com.ivankauchuha.codesharingplatformproject.entities.Code;
import com.ivankauchuha.codesharingplatformproject.exceptions.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class SomeService {

    private final CodeRepository repository;

    @Autowired
    public SomeService(CodeRepository repository) {
        this.repository = repository;
    }

    public void saveCode(Code code) {
        Code newCode = new Code(code);
        System.out.printf("Code was created with UUID %s\n", code.getId());
        repository.save(newCode);
    }

    public Code retrieveCode(String id) {
        Code code = repository.findById(id).orElseThrow(() -> new NotFound(id));
        if (code.hasLimit()) {
            processRestrictions(code);
        }
        return repository.findById(id).orElseThrow(() -> new NotFound(id));
    }

    public List<Code> getLatest() {
        return repository.findTopByOrderByCodeDesc();
    }

    private void processRestrictions(Code code) {
        if (code.isViewsLimit() && code.getViews() >= 0) {
            code.setViews(code.getViews() - 1);
            if (code.getViews() < 0) {
                repository.delete(code);
                return;
            }
        }

        if (code.isTimeLimit() && code.getTime() >= 0) {
            code.setTime(code.getInitialTime() - ChronoUnit.SECONDS.between(LocalDateTime.parse(code.getDate().toString()),
                    LocalDateTime.now()));
            if (code.getTime() < 0) {
                repository.delete(code);
                return;
            }
        }

        repository.save(code);
    }

}
