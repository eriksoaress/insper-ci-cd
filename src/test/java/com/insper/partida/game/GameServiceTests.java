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
        team.setStadium("estadio-1");
        team.setIdentifier("time-1");
        team.setName("time-1");

        Team team2 = new Team();
        team2.setStadium("estadio-2");
        team2.setIdentifier("time-2");
        team2.setName("time-2");

        SaveGameDTO saveGameDTO = new SaveGameDTO();
        saveGameDTO.setHome("time-1");
        saveGameDTO.setAway("time-2");

        Mockito.when(teamService.getTeam("time-1")).thenReturn(team);
        Mockito.when(teamService.getTeam("time-2")).thenReturn(team2);
        GameReturnDTO gameReturnDTO = gameService.saveGame(saveGameDTO);

        Assertions.assertEquals("time-1", gameReturnDTO.getHome());


    }
}
