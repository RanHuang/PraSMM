package com.hr.learn.controller;

import com.hr.learn.model.praise.MoodVO;
import com.hr.learn.service.PraiseServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author nick
 * date 19-6-2 星期日 17:17
 **/
@Controller
@RequestMapping("/praise")
public class PraiseController {
    @Autowired
    @Qualifier("praiseService")
    private PraiseServiceI praiseService;

    @Autowired
    @Qualifier("praiseServiceRedis")
    private PraiseServiceI praiseServiceRedis;

    /**
     * http://localhost:8080/springmvc/praise/moods
     *
     */
    @RequestMapping("/moods")
    public ModelAndView queryAllMood() {
        ModelAndView modelAndView = new ModelAndView();
        List<MoodVO> lstMood = praiseService.queryMood();
        modelAndView.addObject("moods", lstMood);
        modelAndView.setViewName("mood");
        return modelAndView;
    }

    @GetMapping("/{moodId}/praise")
    public String praiseMood(Model model,
                             @PathVariable("moodId") String moodId,
                             @RequestParam("userId") String userId) {
        boolean isPraise = praiseService.praiseMood(userId, moodId);
        List<MoodVO> lstMoods = praiseService.queryMood();
        model.addAttribute("moods", lstMoods);
        model.addAttribute("isPraise", isPraise);
        return "mood";
    }

    @GetMapping("/{moodId}/praiseRedis")
    public String praiseMoodRedis(Model model,
                                  @PathVariable("moodId") String moodId,
                                  @RequestParam("userId") String userId) {
        boolean isPraise = praiseServiceRedis.praiseMood(userId, moodId);
        List<MoodVO> lstMoods = praiseServiceRedis.queryMood();
        model.addAttribute("moods", lstMoods);
        model.addAttribute("isPraise", isPraise);
        return "mood";
    }
}
