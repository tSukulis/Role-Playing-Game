# RPG Battle Simulator

A turn-based RPG battle simulator for the terminal, written in Java. The included demo pits Nick the Warrior against an Orc. Each turn, you can attack or use an inventory item. The Orc retaliates if it survives your turn.

## Object-oriented design

- **Abstraction and inheritance.** The abstract `GameCharacter` class defines shared stats and an attack contract. `Hero` and `Monster` extend it with behavior specific to each side.
- **Polymorphism.** `Battle` calls `attack()` through the hero and monster types. Subclasses such as `Mage` and `Archer` can override how they attack without changing the battle loop.
- **Encapsulation and interfaces.** `GameCharacter` keeps health and defense private and handles damage through `receiveDamage()`. Items implement `Usable`, so the same `use()` call can equip a weapon or apply a potion.

## Getting started

You'll need JDK 21 or later and Apache Maven. From the repository root, build and launch the demo:

```sh
mvn package
java -cp target/rpg_battle_simulator-1.0-SNAPSHOT.jar Main
```

## How to play

- Enter **1** to attack.
- Enter **2** to use an item, then enter its number from the inventory list. You can equip the Bronze Sword or use a potion.
- The battle ends when either character runs out of health. If you win, the hero gains experience. When the loot menu appears, enter an item number to collect it or **0** to exit.

To try a different matchup, edit [Main.java](src/main/java/Main.java) and pass a different hero and monster to `Battle`. The project includes Warrior, Archer, and Mage heroes, along with Orc, Goblin, Dragon, and DinosaurBird monsters.

## Local tests

Run the JUnit tests with `mvn test`. They cover damage calculation, including how defense affects incoming damage and how lethal damage is handled.

## CI/CD

[![CI/CD pipeline](https://github.com/tSukulis/Role-Playing-Game/actions/workflows/maven-publish.yml/badge.svg?branch=main)](https://github.com/tSukulis/Role-Playing-Game/actions/workflows/maven-publish.yml)

The [GitHub Actions workflow](.github/workflows/maven-publish.yml) runs `mvn verify` on pull requests targeting `main` and uses `mvn deploy` to publish Maven artifacts to GitHub Packages on pushes to `main`.
