# Minesweeper

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

| Field  | Type  | Description  |   |   |
|---|---|---|---|---|
| rows  | Integer  | Number of rows  |   |   |
| columns  | Integer  | Number of rows  |   |   |
| mines  | [Position(x, y)]  |  A list of the mines that the game would have |   |   |

#### Response

```
{
    "id": "82c8ca47-e79d-474d-bec8-398df5c3df70"
}
```

| Field  | Type  | Description  |
|---|---|---|---|---|
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
|---|---|---|---|---|
| position  | [Position(x, y)]   | The identifier of the game  |
| value  | String  | The value of the cell, only visible when revealed or flagged  |
| revealed  | Boolean  | Tells if the cell has already been revealed  |
