package com.hr.learn.controller;

import com.hr.learn.model.praise.MoodVO;
import com.hr.learn.service.PraiseServiceI;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author nick
 * @date 19-6-2 星期日 17:17
 **/
@Controller
@RequestMapping("/praise")
public class PraiseController {
    @Resource
    private PraiseServiceI praiseService;

    /**
     * http://localhost:8080/springmvc/praise/moods
     *
     * @return
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
}
