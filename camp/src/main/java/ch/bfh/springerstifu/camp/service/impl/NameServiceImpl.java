package ch.bfh.springerstifu.camp.service.impl;

import java.util.Random;

import org.springframework.stereotype.Service;
import ch.bfh.springerstifu.camp.service.NameService;;

@Service
public class NameServiceImpl implements NameService {

    static final String[] FORENAMES = { "Housi", "Jordan", "Kitty", "Balthasar", "Vreni", "Reiner", "John", "Gordon",
            "Walter", "Mr.", "Mrs.", "Dr.", "Captain", "Lord", "Commander" };

    static final String[] LASTNAMES = { "Hotzenplotz", "Nimmerlich", "Freeman", "Snow", "Winter", "Stark", "White",
            "Heisenberg", "Wilson", "Ryker", "Picard" };

    static final Random RND = new Random(System.currentTimeMillis());

    @Override
    public String getForename() {
        return FORENAMES[RND.nextInt(FORENAMES.length)];
    }

    @Override
    public String getLastname() {
        return LASTNAMES[RND.nextInt(LASTNAMES.length)];
    }

}