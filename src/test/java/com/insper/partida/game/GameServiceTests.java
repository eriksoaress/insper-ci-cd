package com.insper.partida.game;

import com.insper.partida.equipe.Team;
import com.insper.partida.equipe.TeamService;
import com.insper.partida.equipe.dto.TeamReturnDTO;
import com.insper.partida.game.dto.GameReturnDTO;
import com.insper.partida.game.dto.SaveGameDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class GameServiceTests {

    @InjectMocks
    GameService gameService;

    @Mock
    TeamService teamService;
    @Mock
    GameRepository gameRepository;

    @Test
    void test_saveGame(){
        Team team = new Team();
        team.setId("1");
        team.setIdentifier("time-1");
        team.setName("Time 1");

        Team team2 = new Team();
        team2.setId("2");
        team2.setIdentifier("time-2");
        team2.setName("Time 2");

        SaveGameDTO gameDTO = new SaveGameDTO();
        gameDTO.setHome("time-1");
        gameDTO.setAway("time-2");
        GameReturnDTO gameReturnDTO = gameService.saveGame(gameDTO);
        List<Game> resp = gameRepository.findAll();

        Assertions.assertEquals(1, resp.size());


    }
}
