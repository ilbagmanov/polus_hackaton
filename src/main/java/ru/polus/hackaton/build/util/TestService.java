package ru.polus.hackaton.build.util;

import org.springframework.context.annotation.Primary;
import ru.polus.hackaton.build.model.Job;
import ru.polus.hackaton.build.service.Service;

@org.springframework.stereotype.Service
@Primary
public class TestService implements Service {

    @Override
    public boolean algo(Job job) {
        return true;
    }
}
