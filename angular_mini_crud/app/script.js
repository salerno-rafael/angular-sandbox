angular.module('myapp', ['models', 'crud']);

angular.module('myapp').controller('MyCtrl', function($scope, models, CrudApi){
  CrudApi.configure({models: models});
  $scope.models = models;
  $scope.crud_options = {
    fields_dictionary: {
      id: 'Codigo',
      position: 'Posicao',
      symbol: 'Simbolo',
      commoditie: 'Commoditie',
      tipoDolar: 'Tipo de Dolar',
      frete: 'Frete',
      fobbings:'Fobbings',
      premio:'Premio'

    },
  };
   //position, symbol, commoditie, tipoDolar, frete, multiplicador,fobbings, premio
  $scope.financialModel = function(){
    $scope.model = models.Financial;
  };
  
  $scope.financialModel();
  
});