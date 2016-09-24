(function (angular) {
    angular.module("gameOfLife").value("config", {
        steps: 10,
        ms: 500,
        columns: 30,
        rows: 20,
        gameStarted: false,
        running: false
    })
})(angular)
