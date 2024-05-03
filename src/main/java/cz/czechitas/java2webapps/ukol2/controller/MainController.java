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
        int randomCardNumber = random.nextInt(0, 78);
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
        Set<Integer> allCardNumbers = new LinkedHashSet<>(); // Use LinkedHashSet to maintain insertion order
        for (int i = 0; i <= 77; i++) {
            allCardNumbers.add(i);
        }

        List<Integer> shuffledCardNumbers = new ArrayList<>(allCardNumbers);
        Collections.shuffle(shuffledCardNumbers); // Shuffle the list

        List<Integer> selectedCards = shuffledCardNumbers.subList(0, 3); // Pick the first three numbers from the shuffled list

        int randomBackgroundPicture = random.nextInt(1, 8);

        String tarotMeaning1 = readTarotMeaning(selectedCards.get(0)); // Retrieve tarot meaning for card 1
        String tarotMeaning2 = readTarotMeaning(selectedCards.get(1)); // Retrieve tarot meaning for card 2
        String tarotMeaning3 = readTarotMeaning(selectedCards.get(2)); // Retrieve tarot meaning for card 3

        ModelAndView modelAndView = new ModelAndView("threecards");

        modelAndView.addObject("card1", selectedCards.get(0)); // Number on the 1st position of the shuffled list
        modelAndView.addObject("card2", selectedCards.get(1)); // Number on the 2nd position of the shuffled list
        modelAndView.addObject("card3", selectedCards.get(2)); // Number on the 3rd position of the shuffled list
        modelAndView.addObject("tarotMeaning1", tarotMeaning1);
        modelAndView.addObject("tarotMeaning2", tarotMeaning2);
        modelAndView.addObject("tarotMeaning3", tarotMeaning3);
        modelAndView.addObject("randomBackground", randomBackgroundPicture);

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
