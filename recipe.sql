CREATE TABLE Menus (
    MenuID int NOT NULL,            #ID of a menu
    MenuName varchar(100) NOT NULL, #Name of a menu
    Description TEXT NOT NULL,      #description of menu
    PRIMARY KEY (MenuID),
);

CREATE TABLE MenuRecipe (
    MenuID int NOT NULL,            #ID of a menu
    RecipeID int NOT NULL,          #ID of a recipe
    FOREIGN KEY (MenuID) REFERENCES Menu(MenuID)
    FOREIGN KEY (ReceipeID) REFERENCES Recipes(RecipeID)
);

CREATE TABLE Recipes (
    RecipeID int NOT NULL,          #ID of a recipe
    RecipeName varchar(100) NOT NULL,   #name of a recipe
);

CREATE TABLE RecipeIngridient (
    RecipeID int NOT NULL,          #ID of a recipe
    IngredientID int NOT NULL,      #ID of a ingridient
    FOREIGN KEY (RecipeID) REFERENCES Recipes(RecipeId)
    FOREIGN KEY (IngridientID) REFERENCES Ingredients(IngredientID)
);

CREATE TABLE Ingredients (
    IngredientID int NOT NULL,      #ID of a ingridient
    IngredientName TEXT NOT NULL,   #name of a ingridient
    PRIMARY KEY (IngredientID)
);

CREATE TABLE RecipeIngridient (
    RecipeID int NOT NULL,          #ID of a recipe
    InstructionID int NOT NULL,     #ID of a instruction
    FOREIGN KEY (RecipeID) REFERENCES Recipes(RecipeId)
    FOREIGN KEY (InstructionIDID) REFERENCES Instructions(InstructionID)
);

CREATE TABLE Instructions (
    InstructionID int NOT NULL,     #ID of a instruction
    InstructionText TEXT NOT NULL,  #Instruction text
    PRIMARY KEY (InstructonID)
);



