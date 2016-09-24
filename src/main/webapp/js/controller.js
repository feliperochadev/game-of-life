(function (angular) {
    angular.module("gameOfLife").controller("gameOfLifeController", Controller)
    function Controller($scope, $http, config) {
        var loadConfig = function (config) {
            $scope.config = config
            $scope.loadGame = loadGame
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
        loadConfig(config)
    }
})(angular)
