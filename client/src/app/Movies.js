var obj = angular.module("app", ['ngRoute']);

    obj.controller("movieController", ["$scope", "movieDetails", function($scope, movieDetails) {
    $scope.Name = "shivani";
        $scope.displayMovies = function() {
          $scope.response = movieDetails.getMovies();
        };
    }]);

    obj.provider("movieDetails", function() {
        var baseUrl = '';
        this.config = function(url){
            baseUrl = url;
        };

        this.$get = ["$http", "$log", function($http, $log) {
        $log.log("instantiating provider");
        var providerObj = {};
        providerObj.getMovies = function() {
            $http({
                   url : 'localhost:8080/api/movies',
                   method: 'GET',
                   }).then(function(resp) {
                       return resp.data;
                   }, function(resp) {
                        $log.log("Error occured");
                   });
        };
        return providerObj;
        }];
    });

    obj.config("movieDetailsProvider", function($httpProvider, movieDetailsProvider) {
              movieDetailsProvider.config("localhost:8080/api");
              $httpProvider.defaults.useXDomain = true;
              delete $httpProvider.defaults.headers.common['X-Requested-With'];
    });

