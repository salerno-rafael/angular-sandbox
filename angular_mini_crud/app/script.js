angular.module('myapp', ['models', 'crud']);

angular.module('myapp').controller('MyCtrl', function($scope, models, CrudApi){
  CrudApi.configure({models: models});
  $scope.models = models;
  $scope.crud_options = {
    fields_dictionary: {
      id: 'Codigo',
      nome: 'Nome do individuo',
      idade: 'Quantos anos tem'
    },
  };
  
  $scope.gentaiada = function(){
    $scope.model = models.Pessoa;
  };
    
  $scope.gentaiada();
  
});