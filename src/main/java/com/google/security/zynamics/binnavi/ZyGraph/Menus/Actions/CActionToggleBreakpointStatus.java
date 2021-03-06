/*
Copyright 2011-2016 Google Inc. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package com.google.security.zynamics.binnavi.ZyGraph.Menus.Actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.google.security.zynamics.binnavi.Gui.GraphWindows.Implementations.CGraphDebugger;
import com.google.security.zynamics.binnavi.debug.models.breakpoints.BreakpointManager;
import com.google.security.zynamics.binnavi.disassembly.UnrelocatedAddress;
import com.google.security.zynamics.binnavi.disassembly.INaviModule;


/**
 * Action class used to toggle the status of a breakpoint on an address of a module.
 */
public final class CActionToggleBreakpointStatus extends AbstractAction {
  /**
   * Used for serialization.
   */
  private static final long serialVersionUID = -3913927414217740193L;

  /**
   * Breakpoint manager that toggles the event.
   */
  private final BreakpointManager m_manager;

  /**
   * The module in which the breakpoint resides.
   */
  private final INaviModule m_module;

  /**
   * The address of the breakpoint to toggle.
   */
  private final UnrelocatedAddress m_address;

  /**
   * Creates a new action object.
   *
   * @param manager The breakpoint manager that toggles the event.
   * @param module The module in which the breakpoint resides.
   * @param address The address of the breakpoint.
   */
  public CActionToggleBreakpointStatus(final BreakpointManager manager, final INaviModule module,
      final UnrelocatedAddress address) {
    super("Toggle Breakpoint Status");

    m_manager = manager;
    m_module = module;
    m_address = address;
  }

  @Override
  public void actionPerformed(final ActionEvent event) {
    CGraphDebugger.toggleBreakpointStatus(m_manager, m_module, m_address);
  }
}
