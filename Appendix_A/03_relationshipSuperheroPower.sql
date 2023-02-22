CREATE TABLE superheroPower (
  superheroId INT REFERENCES superhero(Id),
  powerId INT REFERENCES power(Id),
  PRIMARY KEY (superheroId, powerId)
);
