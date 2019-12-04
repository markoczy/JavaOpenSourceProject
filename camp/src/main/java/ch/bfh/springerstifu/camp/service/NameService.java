package ch.bfh.springerstifu.camp.service;

import org.springframework.stereotype.Service;

@Service
public interface NameService {

    String getForename();

    String getLastname();
}
