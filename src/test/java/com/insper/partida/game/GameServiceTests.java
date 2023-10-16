package com.insper.partida.game;

import com.insper.partida.equipe.Team;
import com.insper.partida.equipe.dto.TeamReturnDTO;
import com.insper.partida.game.dto.GameReturnDTO;
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
    GameRepository gameRepository;

    @Test
    void test_listGames(){
        Mockito.when(gameRepository.findAll()).thenReturn(new ArrayList<>());

        List<GameReturnDTO> resp = gameService.listGames(null, null, null, null).getContent();

        Assertions.assertEquals(0, resp.size());
    }

    @Test
    void test_listTeamsNotEmpty() {

        Team team = new Team();
        team.setId("1");
        team.setIdentifier("time-1");
        team.setName("Time 1");

        Team team2 = new Team();
        team2.setId("2");
        team2.setIdentifier("time-2");
        team2.setName("Time 2");


        Game game = new Game();
        game.setIdentifier("123");
        game.setHome("time-1");
        game.setAway("time-2");
        game.setAttendance(100);

        List<Game> lista = new ArrayList<>();
        lista.add(game);

        Mockito.when(gameRepository.findAll()).thenReturn(lista);

        List<GameReturnDTO> resp = gameService.listGames(null, null, null, null).getContent();

        Assertions.assertEquals(1, resp.size());
    }
}
