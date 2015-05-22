var app = angular.module('foodHygieneApp', []);
app.controller('RatingCtrl', function ($scope, $http) {
    $scope.loading = true;
    $scope.authorities = undefined;
    $http({
        method: 'GET',
        url: 'http://localhost:8080/authorities'
    }).success(function (data) {
        $scope.authorities = data;
        $scope.loading = false;
    })
        .error(function (data, status, header, config) {
            $scope.showErrorMessage = true;
            $scope.loading = false;
        });

    $scope.getRatingDistribution = function () {
        $scope.loading = true;
        $http({
            method: 'GET',
            url: 'http://localhost:8080/ratingDistributions?localAuthorityId=' + $scope.authorityId
        }).success(function (data) {
            $scope.distributions = data;
            $scope.loading = false;

        })
            .error(function (data, status, header, config) {
                $scope.showErrorMessage = true;
                $scope.loading = false;
            });
    }

    $scope.clearTable = function () {
        $scope.distributions = undefined;
        $scope.showErrorMessage = false;
    }

    function roundNumber(number) {
        return Math.round(number * 10000) / 100;
    }
});


