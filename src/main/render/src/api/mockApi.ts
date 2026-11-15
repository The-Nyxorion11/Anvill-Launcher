import type { LauncherApi, GameVersion } from "./types";

const versiones: GameVersion[] = [
  { id: "1.21", type: "release", installed: true },
  { id: "1.20.4", type: "release", installed: false },
  { id: "24w14a", type: "snapshot", installed: false },
];

export const mockApi: LauncherApi = {
  async getVersions() {
    await new Promise((r) => setTimeout(r, 500)); // simula la espera de red
    return versiones;
  },
};