# RPG Battle Simulator

[![CI/CD pipeline](https://github.com/tSukulis/Role-Playing-Game/actions/workflows/maven-publish.yml/badge.svg?branch=main)](https://github.com/tSukulis/Role-Playing-Game/actions/workflows/maven-publish.yml)

A turn-based RPG battle simulator for the terminal, written in Java. The included demo pits Nick the Warrior against an Orc. Each turn, you can attack or use an inventory item. The Orc retaliates if it survives your turn.

## CI/CD Pipeline

GitHub Actions validates pull requests and publishes Maven artifacts to GitHub Packages after pushes to `main`.

| Trigger | Stage | What runs |
| --- | --- | --- |
| Pull request targeting `main` | **Continuous integration** | `mvn -B verify --file pom.xml` compiles the code, runs the JUnit tests, and packages the application. |
| Push to `main` | **Continuous delivery** | `mvn -B deploy -s "$GITHUB_WORKSPACE/settings.xml"` builds, tests, and publishes the Maven artifact to GitHub Packages. |

Both paths run on Ubuntu with Eclipse Temurin 25. The publish step authenticates with the workflow's `GITHUB_TOKEN` and uses the job's `packages: write` permission.

[Workflow source](.github/workflows/maven-publish.yml)

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
