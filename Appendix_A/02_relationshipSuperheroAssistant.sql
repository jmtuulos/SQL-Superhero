ALTER TABLE superhero
ADD COLUMN assistantId INT REFERENCES assistant(id);

ALTER TABLE assistant
ADD COLUMN superheroId INT REFERENCES superhero(id);

ALTER TABLE assistant
ADD CONSTRAINT fk_superheroId FOREIGN KEY (superheroId) REFERENCES superhero(Id);
