# Minesweeper

This is an API for a minesweeper game

It has the followings features:
- you can select a cell to check if its safe or is a mine
- you can flag a cell to have a mark on it
- you can create multiple games, every time you start one then you access it by an ID

## Endpoints

### Create a new Game

```
POST /
```

```json

{
	"rows": 1,
	"columns": 1,
	"mines": [{
		"x": 0,
		"y": 0
	}]
}

```

#### Body

| Field  | Type  | Description  |
|---|---|---|
| rows  | Integer  | Number of rows  |
| columns  | Integer  | Number of rows  |
| mines  | [Position(x, y)]  |  A list of the mines that the game would have |

#### Response

```
{
    "id": "82c8ca47-e79d-474d-bec8-398df5c3df70"
}
```

| Field  | Type  | Description  |
|---|---|---|
| id  | String  | The identifier of the game  |
| board  | Board  | The state of the board, with the cells  |

### Get a game status

```
GET /
```

#### Response

```json
{
  "status": "PLAYING",
  "board": {
    "cells": [
      [
        {
          "position": {
            "x": 0,
            "y": 0
          },
          "value": null,
          "revealed": false
        }
      ]
    ]
  }
}
```

### Select a cell

```
POST /:gameId
```
```json
{
	"x": 1,
	"y": 0
}
```

### Flag a cell

```
POST /:gameId/flag
```
```json

{
	"x": 1,
	"y": 0
}
```

### Cell

| Field  | Type  | Description  |
|---|---|---|
| position  | Position(x, y)   | The identifier of the game  |
| value  | String  | The value of the cell, only visible when revealed or flagged  |
| revealed  | Boolean  | Tells if the cell has already been revealed  |

### Notes

At the beginning of the development I started creating the core functionality of the game, modeling it and testing. There was a Game and a Board to separate reponsibilities, but then I realize that the Game was just a wrapper of the board that didn't´t have any functionality. I tried to keep the design as simple as possible, without so many layers of abstraction. On the other side, I used SpringBoot for the webserver because I just wanted to focus on the business logic and not lose my time on configurations, also knowing that then it was going to be easier for the deploy.

At first I was thinking in modeling the game with a Graph to avoid the knowledge of the existence of a Position but then I realize that I preferred the simple way of a flat matrix of objects because the rest of the interaction with the users would have to know about an X and Y. So a lot of parsers were gonna be needed without reason.

The other decision about modeling in the core was about the FLAG, at the beginning I started with a Boolean in the cell to know if that cell was flag or not, but then I saw that the flagged cell was having other behavior in some parts of the application, like when I need to print the value of a cell. So then I decided to change it to a decorator.

I would have liked to document it with https://www.openapis.org/ to make it easy for making the client side of the challenge, but I ran out of time so i decided to at least finish with the whole requirement of deployment and at least write the documentation in the MD.


