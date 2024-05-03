package cz.czechitas.java2webapps.ukol2.controller;

import ch.qos.logback.core.util.COWArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@Controller
public class MainController {
    private final Random random = new Random();

    @GetMapping("/onecard")
    public ModelAndView tarrotPage() {
        int randomCardNumber = random.nextInt(0, 22);
        int randomBackgroundPicture = random.nextInt(1, 8);

        String tarotMeaning = readTarotMeaning(randomCardNumber); //read same row as is the random card number

        ModelAndView modelAndView = new ModelAndView("onecard");

        modelAndView.addObject("randomCard", randomCardNumber);
        modelAndView.addObject("randomBackground", randomBackgroundPicture);
        modelAndView.addObject("tarotMeaning", tarotMeaning);
        return modelAndView;
    }


    @GetMapping("/threecards")
    public ModelAndView threeTarrotCards() {
        Set<Integer> selectedCards = new HashSet<>();
        List<String> tarotMeanings = new ArrayList<>(); // Declare tarotMeanings list outside the loop

        while (selectedCards.size() < 3) {
            int randomCardNumber = random.nextInt(0, 22);
            selectedCards.add(randomCardNumber);
            String tarotMeaning = readTarotMeaning(randomCardNumber);
            tarotMeanings.add(tarotMeaning); // Add the tarotMeaning to the list
        }

        int randomBackgroundPicture = random.nextInt(1, 8);

        ModelAndView modelAndView = new ModelAndView("threecards");

        modelAndView.addObject("card1", selectedCards.stream().findFirst().orElse(null));
        modelAndView.addObject("card2", selectedCards.stream().skip(1).findFirst().orElse(null));
        modelAndView.addObject("card3", selectedCards.stream().skip(2).findFirst().orElse(null));
        modelAndView.addObject("randomBackground", randomBackgroundPicture);
        modelAndView.addObject("tarotMeanings", tarotMeanings); // Add the tarotMeanings list

        return modelAndView;
    }

    private String readTarotMeaning(int cardNumber) {
        try {
            List<String> lines = Files.lines(Paths.get("src/main/resources/tarotMeaning.txt")).collect(Collectors.toList());
            return lines.get(cardNumber);

        } catch (IOException e) {
            e.printStackTrace();
            return "Error reading tarotMeaning.txt";
        }
    }
}
