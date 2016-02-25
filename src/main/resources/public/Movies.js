var obj = angular.module("app", ['ngRoute']);

    obj.config(function($httpProvider) {
          $httpProvider.defaults.useXDomain = true;
          delete $httpProvider.defaults.headers.common['X-Requested-With'];
      });

    obj.controller("movieDetails", ["$scope", "$http", function($scope, $http) {
    $scope.Name = "shivani";
        $scope.displayMovies = function() {
          $http({
            url : 'http://localhost:8080/api/movies',
            method: 'GET',
          }).then(function(resp) {
                $scope.response = resp.data;
          }, function(resp) {
          });
        };
    }]);
