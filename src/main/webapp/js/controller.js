(function (angular) {
    angular.module("gameOfLife").controller("gameOfLifeController", Controller)
    function Controller($scope, $http, config) {
        var loadConfig = function (config) {
            $scope.config = config
            $scope.loadGame = loadGame
            $scope.startGame = startGame
            $scope.stopGame = stopGame
            loadGame(config.columns, config.rows)
        }
        var loadGame = function (columns, rows) {
            var cells = []
            for (var y = 0; y < rows; y++) {
                cells[y] = []
                for (var x = 0; x < columns; x++) {
                    cells[y][x] = {y: y, x: x, alive: false}
                }
            }
            $scope.cells = cells;
        }
        var startGame = function (cells, config, firstCall) {
            if ((config.running || firstCall) && config.steps > 0) {
                $http.put("/api/v1/game-of-life", cells).success(function (data) {
                    cells = data
                    $scope.cells = cells
                    config.gameStarted = config.steps > 1 && (config.gameStarted || firstCall)
                    config.running = config.steps > 1 && (config.running || firstCall)
                    config.steps--
                    $scope.config = config
                    setTimeout(function () {
                        startGame(cells, config, false)
                    }, config.ms)
                }).error(function () {
                    stopGame(config)
                })
            }
        }
        var stopGame = function (config) {
            config.gameStarted = false
            config.running = false
            $scope.config = config
        }
        loadConfig(config)
    }
})(angular)