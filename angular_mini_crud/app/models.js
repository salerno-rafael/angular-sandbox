(function(){
  angular.module('models', []);

  angular.module('models').factory('models', function(Financial){
    /**
     * Um objeto pra registrar os meus modelos de coisas persistentes
     */
    var models = {};
    
    models.Financial = Financial;
    
    return models;
  });
  
  angular.module('models').factory('Financial', function(){
    /**
     * Um construtor de Financial
     */
    function Financial(position, symbol,commoditie,tipoDolar,frete,fobbings,premio){
      this.position = position;
      this.symbol = symbol;
      this.commoditie = commoditie;
      this.tipoDolar = tipoDolar;
      this.frete = frete;
      this.fobbings = fobbings;
      this.premio = premio;
    }
    
    Financial.crud_fields = [
      _field('id', 'id'), 
      _field('position', 'int'), 
      _field('symbol', 'string'),
      _field('commoditie', 'string'),
      _field('tipoDolar', 'string'),
      _field('frete', 'int'),
      _field('fobbings', 'int'),
      _field('premio', 'int')
      
    ];
    
    return Financial;
  });
  
  
  function _field(name, type){
    return {
      name: name,
      type: type,
    };
  }
})();
