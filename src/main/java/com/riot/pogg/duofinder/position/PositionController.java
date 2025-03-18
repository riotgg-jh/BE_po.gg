package com.riot.pogg.duofinder.position;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/positions")
public class PositionController {

    private final PositionRepository positionRepository;

    public PositionController(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @GetMapping("/{positionType}")
    public List<Position> getPositionsByType(@PathVariable PositionType positionType) {
        return positionRepository.findByPositionType(positionType);
    }
}
