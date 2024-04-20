package cz.czechitas.java2webapps.ukol2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Controller
public class MainController {
    private final Random random = new Random();

    @GetMapping("/")
    public ModelAndView tarrotPage() {
        int randomCardNumber = random.nextInt(0, 22);
        int randomBackgroundPicture = random.nextInt(1, 8);

        String tarotMeaning = readTarotMeaning(randomCardNumber); //read same row as is the random card number

        ModelAndView modelAndView = new ModelAndView("tarot");
        modelAndView.addObject("randomCard", randomCardNumber);
        modelAndView.addObject("randomBackground", randomBackgroundPicture);
        modelAndView.addObject("tarotMeaning", tarotMeaning);
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
